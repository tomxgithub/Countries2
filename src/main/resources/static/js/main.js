/* Fill in modal with content loaded with Ajax */
$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(e) {// new button or edit
														// button is clicked
		e.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if (text == 'Edit') { // if the text on the button is equal to 'Edit'
			// do the following
			$.get(href, function(country, status) {
				$('.myForm #id').val(country.id);
				$('.myForm #name').val(country.name);
				$('.myForm #capital').val(country.capital);
				$('.myForm #exampleModal').modal('show');
			})
		} else {
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #capital').val('');
			$('.myForm #exampleModal').modal('show');
		}
	})
	// delete button
	$('.table .delBtn').on('click', function(e) {
		e.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal('show');
	})

});