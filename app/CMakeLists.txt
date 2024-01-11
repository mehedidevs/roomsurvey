cmake_minimum_required(VERSION 3.18.1)
add_library(
# Sets the name of the library.
native-lib

# Sets the library as a shared library.
SHARED

# Provides a relative path to your source file(s).
# Associated headers in the same location as their source
# file are automatically included.
src/main/cpp/native-lib.cpp
)