var gulp = require('gulp');
//����gulp���
//js�﷨���
var jshint = require('gulp-jshint');
//sassԤ����
var sass = require('gulp-sass');
//�ļ��ϲ�
var concat = require('gulp-concat');
//jsѹ��
var uglify = require('gulp-uglify');
//������
var rename = require('gulp-rename');
//server����
browserSync = require('browser-sync').create();

var jsFiles = [
  './node_modules/angular/angular.js',
  './node_modules/angular-ui-router/release/angular-ui-router.js'
];

//���ű�
gulp.task('lint', function() {
  gulp.src('./app/**/*.js')
          .pipe(jshint())
          .pipe(jshint.reporter('default'));

})

//����Sass
gulp.task('sass', function() {
  console.log('sass!');
  gulp.src('./app/style/*.scss')
    .pipe(sass())
    .pipe(gulp.dest('./app/style'));
  gulp.src('./app/style/*.css')
    .pipe(concat('style.css'))
    .pipe(gulp.dest('./dist/css'))
})

//�ϲ���ѹ��js�ļ�
gulp.task('scripts', function() {
  gulp.src('./app/**/*.js')
    .pipe(concat('all.js'))
    .pipe(gulp.dest('./dist/js'))
    .pipe(rename('all.min.js'))
    .pipe(uglify())
    .pipe(gulp.dest('./dist/js'));
});
//�ϲ���ѹ������npm��js��Դ�ļ�
gulp.task('npmscripts', function() {
  return gulp.src(jsFiles)
  .pipe(concat('npm.js'))
  .pipe(gulp.dest('./dist/js'))
  .pipe(rename('npm.min.js'))
  .pipe(uglify())
  .pipe(gulp.dest('./dist/js'));
})

//�ϲ���ѹ��css�ļ�
// gulp.task('css', function() {
//   gulp.src('./app/style/*.css')
//     .pipe(concat('style.css'))
//     .pipe(gulp.dest('./dist/css'))
//     // .pipe(rename('style.min.css'))
//     // .pipe(uglify())
//     // .pipe(gulp.dest('./dist/css'));
// });

//ʹ��connect����һ��Web������
gulp.task('browserSync', function () {
  browserSync.init({
         server: {
             baseDir: "./app/"
         }
     });
});

//Ĭ������
gulp.task('default', function() {
  gulp.run('npmscripts');

//����js�仯
browserSync.init({
       server: {
           baseDir: "./"
       }
   });

gulp.watch('./app/**/*.js', ['lint', 'scripts']);

gulp.watch('./app/style/**/*.scss', ['sass']);

// gulp.watch('./app/style/**/*.css', ['css'])

gulp.watch('./app/**', function() {
       console.log('reload');
       browserSync.reload();
   });

})
