package mx.yobijoss.matrices.modules

import mx.yobijoss.matrices.model.Operation

object DynamicModulesUtil {

    fun <T : Operation> loadNewOperationInstance(onDemandPackageName: String,
                                                 onDemandPackageClass: String): T {
        val operationClass = Class.forName("$onDemandPackageName.$onDemandPackageClass")
        val constructor = operationClass.getConstructor()
        return constructor.newInstance() as T
    }
}
