$(function () {
    sliderCommon.initEvents();
    sliderCommon.initStyling();
});

var sliderCommon = {

    initEvents: function() {

    },

    initStyling: function() {

        $('.slider').slick({
            dots: true,
            infinite: true,
            speed: 500,
            fade: true,
//            slide: '> div',
            cssEase: 'linear'
        });
    }
};