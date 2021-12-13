/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 04 - Classe FechaJanela
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.event.*;

class FechaJanela extends WindowAdapter
{
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
}