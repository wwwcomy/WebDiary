void function(_) {
	var $workspace = _('#main'), $window = _(window), $top = _('#top'), 
	$left = _('#aside_left'), $bottom = _('#bottom'), $right = _('#sub_aside_right'), 
	$center = _('#mid_center'), $new = _("#mid_center .news .span6"), 
	wsWidth = 1024, wsHeight = 768;
	
	var onWorkspaceContentLoad = function(){
        var $h1 = $workspace.find('h1'),
            extPanelId = $workspace.find('.x-panel:first').attr('id');
        if (extPanelId && $h1.onlyOne()) {
            Ext.getCmp(extPanelId).setHeight(wsHeight - 6 - $h1.outerHeight(true));
        }
//        _.triggerOfDefaultElementIn($workspace)();
    };

    
	var loadWorkspaceContentByLink = function(/*jQuery.Event*/evt){
        $workspace.load(_(this).attr('href'), onWorkspaceContentLoad);


        return evt.preventDefault() && false;
    };

    // 向 workspace 容器 ajax加载内容的链接
    _('.sidebar').delegate(_('.ws-load[href]'),'click', function(evt){
    	loadWorkspaceContentByLink.call(_(evt.target),evt);
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