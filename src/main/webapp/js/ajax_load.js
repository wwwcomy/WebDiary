void function(_) {
	var $workspace = _('#main'), $window = _(window), $top = _('#top'), 
	$left = _('#aside_left'), $bottom = _('#bottom'), $right = _('#sub_aside_right'), 
	$center = _('#mid_center'), $new = _("#mid_center .news .span6"), 
	wsWidth = 1024, wsHeight = 768;
	
    _('.ws-load[href]').loadingbar({
		  target: "#loadingbar-frame",
		  replaceURL: false,
		  direction: "right",
		 
		  /* Default Ajax Parameters.  */
		  async: true, 
		  complete: function(xhr, text) {},
		  cache: true,
		  error: function(xhr, text, e) {},
		  global: true,
		  headers: {},
		  statusCode: {},
		  success: function(data, text, xhr) {
			  $workspace.html(data);
		  },
		  dataType: "html",
		  done: function(data) {}
		});

    // 向指定容器 ajax加载内容的链接
//    _('.ajax-load[href]').live('click', function(/*jQuery.Event*/evt){
//        var $this = _(this),
//            href = $this.attr('href').addUrlParam($this.data('ajax-params')), // 参数同样要给form
//            formRel = $this.data('form-rel'),
//            target = $this.data('ajax-target');
//        _.fancybox.close(true);
//        $this.activeMenuItem($workspace);
//
//        formRel ?
//            _(formRel).attr('action', href).submit() :
//            _(target).load(href, _.triggerOfDefaultElementIn(target));
//
//        return evt.preventDefault() && false;
//    });
}(window.jQuery);