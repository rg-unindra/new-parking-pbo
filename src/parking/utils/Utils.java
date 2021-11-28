
package parking.utils;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farhan Fadila
 */
public class Utils {
    static NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public static String toRupiah(Number value) {
        return nf.format(value);
    }
}
