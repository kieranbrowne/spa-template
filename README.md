# Single Page Application (leiningen template)

Leiningen template for [reagent](https://github.com/reagent-project/reagent) web apps.


## "Just fucking ship it"

> "Don't have a just idea, just have an idea"

### Here's the workflow.

1. Write code; iterate quickly with figwheel
```
lein figwheel dev
```
Browse to http://localhost:3449.

2. Build code
```
lein clean
lein cljsbuild once min
```

3. Commit code
```
git add resources
git commit -m
```

4. Ship it
```
git subtree push --prefix resources/public/ origin gh-pages
```

Your app is now live at `http://*your-gh-username*.github.io/*repository-name*`


## How to use this template

To create an application:
```
lein new spa <project-name>
```
* [reagent](https://github.com/reagent-project/reagent)
* [figwheel](https://github.com/bhauman/lein-figwheel)

To create an application with extra tools.
```
lein new spa <project-name> +sass
```

### Supported Tools
- [sass](https://github.com/vladh/lein-sassy) (`+sass`)


## Acknowledgements

This template is based on [Matthew Jaoudi's](https://github.com/gadfly361/) [reagent-figwheel](https://github.com/gadfly361/reagent-figwheel) template.

## License

```
The MIT License (MIT)

Copyright © 2017 Kieran Browne

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
