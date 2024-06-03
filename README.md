# Sr. Software Engineer Coding Exercise

# Summary
Write a Java command line program `quotely` which takes as an argument `English` or `Russian` and returns a quote from the forismatic API with the correct language.
If a language is not specified, default to English.

# Instructions

Please write a java program which 
1. Operates on the command line
1. Accepts a language as an argument (either `English` or `Russian`)
1. Fetches results from the forismatic.com quote api (http://forismatic.com/en/api/)
1. Displays to stdout the quote and author

# Further
I have added xml parser and json parser, other parsers can be added and corresponding changes made in the Apihandler will allow all the formats to be supported

For supporting other methods besides getQuote, changes similar to getQuote can be made and corresponding tests added.

More tests can be added for models and processors to increase the coverage.