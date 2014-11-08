$(function () {
    sliderCommon.initEvents();
    sliderCommon.initStyling();
});

var sliderCommon = {

    initEvents: function() {

    },

    initStyling: function() {

        var mobileFlag = $('#mobileFlag').val();
        var slidesToShow = 5;
        if (mobileFlag) {
            slidesToShow = 2;
        }
        $('.slider').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            fade: true,
            asNavFor: '.slider-nav'
        });

        $('.slider-nav').slick({
            slidesToShow: slidesToShow,
            slidesToScroll: 1,
            asNavFor: '.slider',
            centerMode: true,
            focusOnSelect: true
        });
    }
};