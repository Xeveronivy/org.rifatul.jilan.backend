package org.sapto.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Buku implements List<Buku> {
    private String judulBuku;
    private String pengarangBuku;
    private double hargaBuku;
    private double diskonBuku;

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarangBuku() {
        return pengarangBuku;
    }

    public void setPengarangBuku(String pengarangBuku) {
        this.pengarangBuku = pengarangBuku;
    }

    public double getHargaBuku() {
        return hargaBuku;
    }

    public void setHargaBuku(double hargaBuku) {
        this.hargaBuku = hargaBuku;
    }

    public double getDiskonBuku() {
        return diskonBuku;
    }

    public void setDiskonBuku(double diskonBuku) {
        this.diskonBuku = diskonBuku;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Buku> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Buku buku) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Buku> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Buku> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Buku get(int index) {
        return null;
    }

    @Override
    public Buku set(int index, Buku element) {
        return null;
    }

    @Override
    public void add(int index, Buku element) {

    }

    @Override
    public Buku remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Buku> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Buku> listIterator(int index) {
        return null;
    }

    @Override
    public List<Buku> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void setPublisherId(int publisherId) {

    }
    public void setPublisherName(String publisherName) {
        {

        }

    }
}


/*
    public void setJudulDanPengarang(String namaBuku, String pengarang){
        this.judulBuku = namaBuku;
        this.pengarangBuku = pengarang;
    }
    public String getJudulDanPengarang(){
        return this.judulBuku+" "+this.pengarangBuku;
    }*/