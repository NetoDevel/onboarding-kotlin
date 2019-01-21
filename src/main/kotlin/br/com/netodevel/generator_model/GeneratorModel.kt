package br.com.netodevel.generator_model

class GeneratorModel() {

    fun generate(model: Model) : String {
        if (model.className.isNullOrEmpty() || model.parameters.isNullOrEmpty())
            throw IllegalArgumentException()

        return generateClass(model.className!!)
                .plus(generateParams(model.parameters!!));
    }

    fun generateParams(params: String) : String {
        val splitParams = params.split(" ")
        return splitParams.map{ "val $it" }.joinToString(", ", "(", ")")
    }

    fun generateClass(className: String) : String {
        return "class ${className}"
    }
}