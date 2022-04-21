package org.sapto.model;

import java.util.List;
public class KeranjangBuku {
    private List<Buku> listBuku;
    private Buku[] bukuArray = new Buku[10];

    public List<Buku> getListBuku() {
        return listBuku;
    }

    public void setListBuku(List<Buku> listBuku) { this.listBuku = listBuku;
    }
}
