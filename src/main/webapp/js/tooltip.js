/**
 * 
 */

$(document).ready(function(){
	
	var ajax_url = 'http://...';
	
	$('.logo-block-click').click(function(e){
		window.location = ajax_url; 
	});
	
	$('img.menu_item').imghover({suffix: '_over'});
	
	$("img.title").tooltip({
		tip: '.ajax',
		effect: 'slide'
	}).dynamic({ bottom: { direction: 'down', bounce: true } });
	
	jqueryslidemenu.buildmenu("myslidemenu");
	
	// скрываем автограф
	$("#FoxForm > div:last").hide();
	
	var $last = null;
	
	function update_toggle() {
		$last = null;
		
		$('div.header').click(function(){
	        $current = $(this).next();
	        $close = false;
	        if ($last) {
	            if ( $last.attr('id') != $current.attr('id') ) {
	                $last.slideToggle("slow");
	            }
	            else {
	                $close = true;                    
	            } // if
	        } // if        
	        $current.slideToggle("slow");
	        if ($close)            
	        	$last = null;
	        else   		
	    		$last = $current;		
		});		
	}
	update_toggle();
	
	$('.move').insertAfter($("#FoxForm > div:first"));
	
	$( "#sortable" ).sortable({
		placeholder: "ui-state-highlight"
	});
	$( "#sortable" ).disableSelection();
	
	$('.add').click(function(){
		var id = $(this).attr('itemId');

		// content
		var productX = $(this).offset().left;
		var productY = $(this).offset().top;
		
		// basket
		var basketX  = $('.bag').offset().left;
		var basketY  = $('.bag').offset().top;	
		
		var gotoX 	 = basketX - productX;
		var gotoY 	 = basketY - productY;
					
		var $new = $(this).clone();		
		
		
		
		$new
			.prependTo($(this))
			.css({'position' : 'absolute'})
			.animate({opacity: 0.9}, 100 )
			.animate({opacity: 0.4,
				marginLeft: gotoX, 
				marginTop: gotoY}, 2000, function() {
					$('.ajax').show();
					
					var s = 'bu_zajavka_over.png';
					var n = 'bu_zajavka.png';
					
					$('#img_bag').attr('src', s);
					
					var url = ajax_url + '?save';
					$new.fadeOut('slow', function(){
						$(this).remove();
					});
					var title = $(this).attr('slug');
					var link = $(this).attr('link');
					
					$.post(url, {link: link, title: title}, function(data) {
						$('#img_bag').attr('src', n);
						Alert();
						$('.ajax').hide();
					},
					'json').
					error(function(){
						alert('Сервис временно не доступен повторите позже');
						$('.ajax').hide();
					});
				});		
	});
	
	//hover states on the static widgets
	$('.delete').hover(
		function() { $(this).addClass('ui-state-hover'); }, 
		function() { $(this).removeClass('ui-state-hover'); }
	);	
		
	function up( enabled ) {
		if (enabled) {
			$('.foxbutton').removeAttr('disabled');
			$('.items-n').addClass('hidden');
			$('.items-v').removeClass('hidden');
		}
		else {
			$('.items-v').addClass('hidden');
			$('.items-n').removeClass('hidden');
			$('.foxbutton').attr('disabled', 'disabled');			
		} // if			
	}	
	up( true );
	
	function Alert() {		
		$('#dialog-alert').dialog('destroy');
		$('#dialog-alert').dialog({
			modal: true,
			resizable: false,
			height: 200,
			width: 400,		
			buttons: {
				'Ok': function () {
					$(this).dialog('close');					
				}
			}
		});				
	}
	
	$('.delete').click(function(){
		var cl = $(this).attr('item');
		$('#dialog-confirm').dialog('destroy');
		$('#dialog-confirm').dialog({
			modal: true,
			resizable: false,
			height: 150,
			width: 300,		
			buttons: {
				'Да': function() {
					var url = ajax_url + '?delete';
					$.post(url, {hash: cl}, function(data) {
						if (data.count < 1 ) up( false );
						$('#dialog-confirm').dialog('close');
						if (data.ok) {
							$('.' + cl).fadeOut('slow', function(){
								$(this).remove();							
							});							
						} // if
					},
					'json').
					error(function(){
						alert('Сервис временно не доступен повторите позже');
					});
				},	
				'Нет': function () {
					$(this).dialog('close');					
				}
			}
		});				
	});
	
});