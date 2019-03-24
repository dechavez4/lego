/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Renz
 */
public class bandCalculator {

    public int[] legoCalculator(int Width, int Length, int Height, int bandType) {
        int x4 = 0;
        int x2 = 0;
        int x1 = 0;

        int[] list = new int[6];
        //udregnig af længden
        list[0] = x4;
        list[1] = x2;
        list[2] = x1;
        //udregning af bredden
        list[3] = x4;
        list[4] = x2;
        list[5] = x1;

        switch (bandType) {
            case 1:
                //width
                if (Width < 4) {
                    list[0] = 0;
                }
                if (Width % 4 == 0) {
                    list[0] = (Width / 4) * 2 * Height;
                }
                if (Width > 4) {
                    list[0] = ((Width - (Width % 4)) / 4) * 2 * Height;
                }
                if (Width % 4 == 2) {
                    list[1] = 1 * 2 * Height;
                }
                if (Width % 4 == 1) {
                    list[2] = 1 * 2 * Height;
                }
                if (Width % 4 == 2) {
                    list[1] = 1 * 2 * Height;
                    list[2] = 1 * 2 * Height;
                }
                //length
                if (Length < 4) {
                    list[3] = 0;
                }
                if (Length % 4 == 0) {
                    list[3] = (Length / 4) * 2 * Height;
                }
                if (Length > 4) {
                    list[3] = ((Length - (Length % 4)) / 4) * 2 * Height;
                }
                if (Length % 4 == 2) {
                    list[4] = 1 * 2 * Height;
                }
                if (Length % 4 == 1) {
                    list[5] = 1 * 2 * Height;
                }
                if (Length % 4 == 2) {
                    list[4] = 1 * 2 * Height;
                    list[5] = 1 * 2 * Height;
                }
                break;
            //second bandtype
            case 2:

                break;
            //third bandtype
            case 3:

                break;
            //fourth bandtype
            case 4:

                break;
            default:
                throw new AssertionError();
        }
        return list;

    }
}
