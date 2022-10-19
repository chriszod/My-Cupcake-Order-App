package com.example.mycupcakeapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }

    @Test
    fun price_twelve_cupcakes_tomorrow() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        viewModel.setDate("Sun Oct 23")
        assertEquals("$24.00", viewModel.price.value)
    }
}