package br.com.netodevel.route_manager

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