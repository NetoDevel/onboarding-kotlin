package br.com.netodevel.generator_model

import org.junit.Assert.assertEquals
import org.junit.Test

class GeneratorModelTest {

    @Test(expected = IllegalArgumentException::class)
    fun dadoUmObjetoModelInvalido_deveLancarExcecao() {
        val model = Model("", "")
        GeneratorModel().generate(model)
    }

    @Test(expected = IllegalArgumentException::class)
    fun dadoClassNameInvalido_deveLancarExcecao() {
        val model = Model("", "name:String")
        GeneratorModel().generate(model)
    }

    @Test(expected = IllegalArgumentException::class)
    fun dadoParametersInvalido_deveLancarExcecao() {
        val model = Model("User", "")
        GeneratorModel().generate(model)
    }

    @Test(expected = IllegalArgumentException::class)
    fun dadoClassNameNull_deveLancarExcecao() {
        val model = Model(null, "name:String")
        GeneratorModel().generate(model)
    }

    @Test(expected = IllegalArgumentException::class)
    fun dadoParametersNull_deveLancarExcecao() {
        val model = Model("User", null)
        GeneratorModel().generate(model)
    }

    @Test
    fun dadoUmModelValido_deveRetornarModelGerado() {
        val model = Model("User", "name:String idade:Int")
        val modelGenerated = GeneratorModel().generate(model)
        assertEquals("class User(val name:String, val idade:Int)", modelGenerated)
    }

    @Test
    fun dadoUmClassName_deveRetornarNomeClassGerada() {
        val classGenerated = GeneratorModel().generateClass("User")
        assertEquals("class User", classGenerated)
    }

    @Test
    fun dadoParameters_deveRetornarTodosAtributosGerados() {
        val classGenerated = GeneratorModel().generateParams("name:String idade:Int")
        assertEquals("(val name:String, val idade:Int)", classGenerated)
    }

    @Test
    fun dadoUnicoParametro_deveRetornarTodosAtributosGerados() {
        val classGenerated = GeneratorModel().generateParams("name:String")
        assertEquals("(val name:String)", classGenerated)
    }

    @Test
    fun dadoUmModelValidoComApenasUmParametro_deveRetornarModelGerado() {
        val model = Model("User", "name:String")
        val modelGenerated = GeneratorModel().generate(model)
        assertEquals("class User(val name:String)", modelGenerated)
    }

}