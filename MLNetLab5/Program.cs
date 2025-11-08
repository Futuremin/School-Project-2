using System;
using Microsoft.ML;
using Microsoft.ML.Data;

namespace MLNetLab5
{
    class Program
    {
        static void Main(string[] args)
        {
            RunRegressionModel();    // Question 2
            RunClusteringModel();    // Question 3
        }

        // Question 2: Predict medical cost
        static void RunRegressionModel()
        {
            var context = new MLContext();

            var data = context.Data.LoadFromTextFile<InsuranceData>(
                "insurance.csv", hasHeader: true, separatorChar: ',');

            var pipeline = context.Transforms.Concatenate("Features", "Age", "Bmi", "Children")
                .Append(context.Regression.Trainers.Sdca(labelColumnName: "Charges"));

            var model = pipeline.Fit(data);

            var engine = context.Model.CreatePredictionEngine<InsuranceData, InsurancePrediction>(model);

            var sample = new InsuranceData { Age = 30, Bmi = 28.5f, Children = 2 };
            var prediction = engine.Predict(sample);

            Console.WriteLine($"[Question 2] Predicted medical cost: ${prediction.PredictedCost:F2}");
        }

        // Question 3: Cluster student knowledge level
        static void RunClusteringModel()
        {
            var context = new MLContext();

            var studentData = context.Data.LoadFromTextFile<Student>(
                "Student.csv", hasHeader: false, separatorChar: ',');

            var pipeline = context.Transforms.Concatenate("Features",
                    nameof(Student.STG), nameof(Student.SCG),
                    nameof(Student.STR), nameof(Student.LPR), nameof(Student.PEG))
                .Append(context.Clustering.Trainers.KMeans("Features", numberOfClusters: 3));

            var model = pipeline.Fit(studentData);

            var engine = context.Model.CreatePredictionEngine<Student, ClusterPrediction>(model);

            var sample = new Student
            {
                STG = 0.7f,
                SCG = 0.6f,
                STR = 0.8f,
                LPR = 0.85f,
                PEG = 0.75f
            };

            var prediction = engine.Predict(sample);
            Console.WriteLine($"[Question 3] Student is in cluster: {prediction.PredictedClusterId}");
        }
    }

    // Supporting classes for Question 2
    public class InsuranceData
    {
        [LoadColumn(0)] public float Age;
        [LoadColumn(1)] public float Sex; // Not being used model
        [LoadColumn(2)] public float Bmi;
        [LoadColumn(3)] public float Children;
        [LoadColumn(4)] public float Smoker;
        [LoadColumn(5)] public float Region;
        [LoadColumn(6)] public float Charges;
    }

    public class InsurancePrediction
    {
        [ColumnName("Score")]
        public float PredictedCost;
    }
}