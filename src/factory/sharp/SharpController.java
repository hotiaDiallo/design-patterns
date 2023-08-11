package factory.sharp;

import factory.korner.KornerControlller;
import factory.korner.ViewEngine;

public class SharpController extends KornerControlller {
    @Override
    protected ViewEngine createViewEngine() {
        return new SharpViewEngine();
    }
}
