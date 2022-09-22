package fr.codebusters.libkata.Model;

public class Category {
    private enum category {KIDS, NOVEL, SCIENTIFIC};
    private category c;

    public Category(category c) {
        this.c = c;
    }
}
