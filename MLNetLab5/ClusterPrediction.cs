using Microsoft.ML.Data;

public class ClusterPrediction
{
    [ColumnName("PredictedLabel")]
    public uint PredictedClusterId;
    public float[]? Distance;
}