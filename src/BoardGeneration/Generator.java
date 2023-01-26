package BoardGeneration;

class Generator
{
    private double[] percentages;

    public Generator()
    {
        // source: https://www3.nd.edu/~busiforc/handouts/cryptography/letterfrequencies.html
        percentages = new double[] {8.4966, 2.0720, 4.5388, 3.3844, 11.1607, 1.8121, 2.4705, 3.0034, 7.5448, 0.1965, 1.1016, 5.4893, 3.0129, 6.6544, 7.1635, 3.1671, 0.1962, 7.5809, 5.7351, 6.9509, 3.6308, 1.0074, 1.2899, 0.2902, 1.7779, 0.2722};
    }

    public char generateLetter()
    {
        double choice = (Math.random() * 100);
        double sum = 0;

        for (int i = 0; i < percentages.length; i++)
        {
            sum += percentages[i];

            if (choice <= sum)
            return (char)(65 + i);
        }

        return '.';
    }
}
