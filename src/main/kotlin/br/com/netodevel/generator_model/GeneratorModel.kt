package br.com.netodevel.generator_model

class GeneratorModel() {

    fun generate(model: Model) : String {
        if (model.className.isNullOrEmpty() || model.parameters.isNullOrEmpty())
            throw IllegalArgumentException()

        return generateClass(model.className!!).plus(generateParameters(model.parameters!!));
    }

    fun generateClass(className: String) : String {
        return "class ${className}"
    }

    fun generateParameters(params: String): String {
        val splitParams = params.split(" ")
        var paramsGenerated = "("

        for (i in splitParams.indices) {
            if (isLastElement(splitParams, i) && !onlyOneElement(splitParams)) {
                paramsGenerated += "val ${splitParams[i]})"
            }

            if (onlyOneElement(splitParams)) {
                paramsGenerated += "val ${splitParams[i]})"
            }

            if (!onlyOneElement(splitParams) && !isLastElement(splitParams, i)){
                paramsGenerated += "val ${splitParams[i]}, "
            }
        }

        return paramsGenerated
    }

    private fun onlyOneElement(splitParams: List<String>) = splitParams.size == 1
    private fun isLastElement(splitParams: List<String>, i: Int) = splitParams.size == i + 1

}