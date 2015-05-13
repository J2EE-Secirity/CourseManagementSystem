
var jqueryslidemenu = {
animateduration: {over: 150, out: 50},
buildmenu:function(menuid){
	jQuery(document).ready(function($){
		
		$('li').hover(function(e){
					if ( ! (
						    	 $(this).hasClass('top') 
						      || $(this).hasClass('bottom')
						      || $(this).hasClass('selected')
						   ) 
						)
						$(this).addClass('hover');
				},
				function(e){
					$(this).removeClass('hover');
				});
						
		var $mainmenu=$("#"+menuid+">ul");
		var $headers=$mainmenu.find("ul").parent();
		$headers.each(function(i) {
			var $curobj=$(this);			
			var $subul=$(this).find('ul:eq(0)');
			
			this._dimensions = 
					{ 
					  w:this.offsetWidth, 
					  h:this.offsetHeight, 
					  subulw:$subul.outerWidth(), 
					  subulh:$subul.outerHeight()
					};
			this.istopheader = $curobj.parents("ul").length==1 ? true : false;
			
			$subul.css({
					left:this.istopheader ? this._dimensions.w+"px" : 0
			});
	
			$curobj.hover(function(e){					
					var $lala = $(this);
					var $targetul=$(this).children("ul:eq(0)");
					
					this._offsets = { 
								left : $(this).offset().left, 
								top : $(this).offset().top
							};
	
					$lala.css({});
	
					var menuleft=this._dimensions.w;
					$targetul.css({top:"0px"});
	
					menuleft = (
								this._offsets.left + menuleft+this._dimensions.subulw > $(window).width()) ? 
										(this.istopheader ? - this._dimensions.subulw + this._dimensions.w : 
											-this._dimensions.w) : menuleft;
					$targetul.css({
							left:menuleft + "px",
							width : this._dimensions.subulw + 'px'
						})
						.fadeIn(jqueryslidemenu.animateduration.over);
						//.slideDown( jqueryslidemenu.animateduration.over );
	
				},
				function(e){
					var $targetul = $(this).children("ul:eq(0)");
					$targetul
						.fadeOut(jqueryslidemenu.animateduration.out);
						//.slideUp(jqueryslidemenu.animateduration.out);
				});
		});
		
		$mainmenu.find("ul").css({display:'none', visibility:'visible'});
	});
}};
