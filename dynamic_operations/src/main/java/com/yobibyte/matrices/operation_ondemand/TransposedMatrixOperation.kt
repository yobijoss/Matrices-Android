package com.yobibyte.matrices.operation_ondemand

import mx.yobijoss.matrices.model.Operation

class TransposedMatrixOperation : Operation() {
    override fun getName() = "Matriz Transpuesta"

    override fun operate(matrix1: Array<DoubleArray>, matrix2: Array<DoubleArray>): Array<DoubleArray> {
        val result = Array(matrix1[0].size) { DoubleArray(matrix1.size) }
        for (i in matrix1.indices) {
            for (j in matrix1.indices) {
                result[i][j] = matrix1[j][i]
            }
        }
        return result
    }

}