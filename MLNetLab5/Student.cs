using Microsoft.ML.Data;

public class Student
{
    [LoadColumn(0)] public float STG;
    [LoadColumn(1)] public float SCG;
    [LoadColumn(2)] public float STR;
    [LoadColumn(3)] public float LPR;
    [LoadColumn(4)] public float PEG;
}