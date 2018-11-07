package mx.yobijoss.matrices.model

class MultiplyOperation : Operation() {
    override fun getName() = "Multiplicación"

    override fun operate(matrix1: Array<DoubleArray>, matrix2: Array<DoubleArray>): Array<DoubleArray> {
        val resultArray = arrayOf(DoubleArray(4), DoubleArray(4), DoubleArray(4), DoubleArray(4))

        for (i in 0 until matrix1.size) {
            for (j in 0 until matrix2[0].size) {
                for (k in 0 until matrix1[0].size) {
                    resultArray[i][j] += matrix1[i][k] * matrix2[k][j]
                }
            }
        }
        return resultArray
    }
}
