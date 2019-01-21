package br.com.netodevel.router_manager

import br.com.netodevel.route_manager.RouterManager
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class RouterManagerTest {

    @Test(expected = IllegalArgumentException::class)
    fun dadoUmaUrlNula_deveLancarException() {
        val routerManager = RouterManager()
        routerManager.execute(null);
    }

    @Test(expected = IllegalArgumentException::class)
    fun dadoUmaUrlVazia_deveLancarException() {
        val routerManager = RouterManager()
        routerManager.execute("");
    }

    @Test
    fun dadoUrlUsers_deveRetornarTrue() {
        val routerManager = RouterManager(Arrays.asList("/", "/users", "/comments"))
        val match = routerManager.execute("/users");

        assertEquals(true, match)
    }

    @Test
    fun dadoOutraRota_deveRetornarTrue() {
        val routerManager = RouterManager(Arrays.asList("/", "/users", "/comments"))
        val match = routerManager.execute("/");

        assertEquals(true, match)
    }

    @Test
    fun dadoUmaRotaNaoExistente_deveRetornarFalse() {
        val routerManager = RouterManager(Arrays.asList("/", "/users", "/comments"))
        val match = routerManager.execute("/nao-existe");

        assertEquals(false, match)
    }

    @Test
    fun dadoUmaRotaComParametrosDeveRetornarTrue() {
        val routerManager = RouterManager(Arrays.asList("/", "/users/{user_id}", "/comments/{user_id}"))
        val match = routerManager.execute("/users/1");

        assertEquals(true, match)
    }

    @Test
    fun dadoOutraRotaComParametrosDeveRetornarTrue() {
        val routerManager = RouterManager(Arrays.asList("/", "/users/{user_id}", "/comments/{user_id}"))
        val match = routerManager.execute("/comments/1");

        assertEquals(true, match)
    }

}