<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});


// Route::get('monumentos', function () {
//     return App\Models\Monumento::all();
// });

Route::get('añadir-monumento', function () {

    App\Models\Monumento::create([
    'nombre' => 'Estatua de la Libertad',
    'ciudad' => 'Nueva York',
    'pais' => 'Estados Unidos',
    'descripcion' => 'Un símbolo de libertad y democracia.'
    ]);

    App\Models\Monumento::create([
    'nombre' => 'Torre Eiffel',
    'ciudad' => 'París',
    'pais' => 'Francia',
    'descripcion' => 'Una estructura icónica de hierro forjado.'
    ]);

    App\Models\Monumento::create([
    'nombre' => 'Gran Muralla China',
    'ciudad' => 'Beijing',
    'pais' => 'China',
    'descripcion' => 'Una antigua serie de fortificaciones de piedra y tierra.'
    ]);

    App\Models\Monumento::create( [
    'nombre' => 'Machu Picchu',
    'ciudad' => 'Cusco',
    'pais' => 'Perú',
    'descripcion' => 'Una ciudadela incaica en las montañas de los Andes.'
    ]);

    App\Models\Monumento::create([
    'nombre' => 'Coliseo Romano',
    'ciudad' => 'Roma',
    'pais' => 'Italia',
    'descripcion' => 'Un anfiteatro antiguo utilizado para espectáculos públicos.'
    ]);

    App\Models\Monumento::create([
    'nombre' => 'Taj Mahal',
    'ciudad' => 'Agra',
    'pais' => 'India',
    'descripcion' => 'Un inmenso mausoleo de mármol blanco, una de las siete maravillas del mundo.'
    ]);


    return App\Models\Monumento::all();
});