/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Exception.InputKosongException;

/**
 *
 * @author farel
 */
public abstract class PaketServisE extends PaketServis {

    public PaketServisE(String id, String nama, String jenis, int durasi) throws InputKosongException {
        super(id, nama, jenis, durasi);
    }

    public PaketServisE(String nama, String jenis, int durasi) throws InputKosongException {
        super(nama, jenis, durasi);
    }


    @Override
    public String toString() {
        return getNama();
    }
}
