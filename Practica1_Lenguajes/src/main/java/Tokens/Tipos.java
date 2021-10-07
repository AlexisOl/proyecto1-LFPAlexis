/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokens;

/**
 *
 * @author alexis
 * ENUM para los tokens, este sera nuestro alfabeto.
 * Enum para determinar los tipos de tokens que hay en el problema, agregandole los errores
 */

public enum Tipos {
    IDENTIFICADOR,
    DIGITOS,
    DECIMALES,
    SIGNOS_PUNTUACION,
    OPERADORES_ARITMETICOS,
    SIGNOS_AGRUPACION,
    ESPACIO,
    ERRORES;
    
}
