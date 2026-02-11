package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MyArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                arguments("Robert0 Koch","feide@gmail.com","Berlin"),
                arguments("Robert1 Koch1","feide@gmail.com","Berlin"),
                arguments("Robert2 Weide2","gmail.feide@gmail.com","Berlin")

        );
    }
}
