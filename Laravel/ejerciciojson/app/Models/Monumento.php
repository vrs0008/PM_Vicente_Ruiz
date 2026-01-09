<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Monumento extends Model
{
    protected $fillable = [
        'nombre',
        'ciudad',
        'pais',
        'descripcion',
    ];
}
