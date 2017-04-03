# {{name}}

A single page application designed for...

## Workflow

1. Write code
```
lein figwheel dev
```
Browse to [http://localhost:3449](http://localhost:3449).

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

## Moar Tools
{{#sass?}}
### Sass
```
;; compile sass once
lein sass
;; compile sass and watch for changes
lein sass watch
```
{{/sass?}}
{{#cider?}}
### Cider
Put this in your Emacs config file:
```
(setq cider-cljs-lein-repl "(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")
```
Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`) or (`SPACE s I` (for spacemacs))
{{/cider?}}
