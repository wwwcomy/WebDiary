var gulp = require('gulp');
var clean = require('gulp-clean');
var concat = require('gulp-concat');
var browserSync = require('browser-sync').create();
var runSequence = require('run-sequence');

var paths = {
    js: ['src/js/*.js'],
    css: ['src/css/*'],
    img: ['src/img/*'],
    html: ['src/html/**/*.html'],
    lib: {
        js: ['node_modules/angular/angular.js',
            'node_modules/angular-ui-router/release/angular-ui-router.js',
            'node_modules/trix/dist/trix.js',
            'node_modules/angular-trix/dist/angular-trix.js',
            'node_modules/angular-bootstrap-nav-tree/dist/abn_tree_directive.js'
        ],
        css: ['node_modules/bootstrap/dist/css/bootstrap.css', 'node_modules/trix/dist/trix.css', 'node_modules/angular-bootstrap-nav-tree/dist/abn_tree.css'],
        img: []
    }
};

gulp.task('clean', function() {
    return gulp.src('dist', {
        read: false
    }).pipe(clean());
});

gulp.task('build-dep-js', function() {
    return gulp.src(paths.lib.js)
        .pipe(concat('dependent.js'))
        .pipe(gulp.dest('./dist/js'));
});

gulp.task('build-dep-css', function() {
    return gulp.src(paths.lib.css)
        .pipe(concat('dependent.css'))
        .pipe(gulp.dest('./dist/css'));
});

gulp.task('build-html', function() {
    gulp.src(paths.html).pipe(gulp.dest('./dist'));
});

gulp.task('build-img', function() {
    gulp.src(paths.img).pipe(gulp.dest('./dist/img'));
});
gulp.task('build-css', function() {
    gulp.src(paths.css).pipe(gulp.dest('./dist/css'));
});

gulp.task('build-js', function() {
    gulp.src(paths.js).pipe(concat('main.js')).pipe(gulp.dest('./dist/js'));
    browserSync.reload();
});

gulp.task('build-js-watch', ['build-js'], function(done) {
    browserSync.reload();
    done();
});

gulp.task('build-html-watch', ['build-html'], function(done) {
    browserSync.reload();
    done();
});

gulp.task('browserSync', function() {
    browserSync.init({
        server: {
            baseDir: "./dist/"
        }
    });
});

gulp.task('watch', function() {
    gulp.watch('src/js/**/*.js', ['build-js-watch']);
    gulp.watch(paths.html, ['build-html-watch']);
});

gulp.task('build', ['build-dep-js', 'build-dep-css', 'build-html', 'build-css', 'build-js', 'build-img'], function() {});

gulp.task('dev', [], function() {
    runSequence('clean', ['build', 'browserSync', 'watch']);
});

gulp.task('default', ['clean'], function() {});
