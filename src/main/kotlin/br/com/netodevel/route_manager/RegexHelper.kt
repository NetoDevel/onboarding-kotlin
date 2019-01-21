package br.com.netodevel.route_manager

import java.lang.IllegalArgumentException
import java.util.regex.Pattern

class RegexHelper {

    /**
     * Converte a url da sua rota para regex.
     *
     * @param  urlMapped
     * @return Regex from string
     */
    fun generatorRegexFromUrl(urlMapped: String?): String? {
        if (urlMapped.isNullOrEmpty()) throw IllegalArgumentException()
        return urlMapped?.replace("\\{\\w*\\}".toRegex(), "\\\\w*")
    }

    /**
     * Compara regex da url mapeada com a url requisitada.
     * @param regex
     * @param urlOrigin
     * @return
     */
    fun matchUrl(regex: String?, urlOrigin: String?): Boolean {
        val p = Pattern.compile(regex)
        val m = p.matcher(urlOrigin)
        return m.matches()
    }
}