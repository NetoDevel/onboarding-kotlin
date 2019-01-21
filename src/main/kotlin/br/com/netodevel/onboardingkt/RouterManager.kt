package br.com.netodevel.onboardingkt

class RouterManager(var routes: List<String>? = null) {

    val regexHelper = RegexHelper()

    fun execute(url: String?) : Boolean? {
        if (!url.isNullOrEmpty()) {
            return this.routes?.map { route ->  regexHelper.generatorRegexFromUrl(route) }
                    ?.filter { f -> regexHelper.matchUrl(f, url) }
                    ?.isNotEmpty()
        }

        throw IllegalArgumentException()
    }

}