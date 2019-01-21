package br.com.netodevel.onboardingkt

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class RegexHelperTest {

    @Test(expected = IllegalArgumentException::class)
    fun dadoUmaUrlNula_deveLancarExcecao() {
        RegexHelper().generatorRegexFromUrl(null)
    }

    @Test
    fun dadoUmaUrl_deveRetornarORegex() {
        val regex = RegexHelper().generatorRegexFromUrl("/users/{user_id}")
        assertEquals("/users/\\w*", regex)
    }

    @Test
    fun deveDarUmMatch() {
        val urlOrigin = "/users/1"
        val regex = "/users/\\w*"

        assertTrue(RegexHelper().matchUrl(regex, urlOrigin))
    }

}