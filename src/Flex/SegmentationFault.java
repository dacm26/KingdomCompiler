/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flex;

/**
 *
 * @author C5220701
 */
public class SegmentationFault extends Exception {

    public SegmentationFault() {
        super();
    }

    public SegmentationFault(String message) {
        super(message);
    }

    public SegmentationFault(String message, Throwable cause) {
        super(message, cause);
    }

    public SegmentationFault(Throwable cause) {
        super(cause);
    }
}
