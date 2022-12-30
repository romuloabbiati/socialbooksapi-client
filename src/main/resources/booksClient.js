$(function() {
	$(".js-load-books").on('click', function() {
		$.ajax({
			url: "http://localhost:8080/books",
			type: "get",
			headers: {
				"Authorization": "Basic cm9tdWxvYWJiaWF0aTpzM25oNA=="
			},
			success: function(response) {
				drawTable(response);
			}
		});
	})
});

function drawTable(result) {
	$(".js-books-table-body tr").remove();
	for(var i=0; i < result.length; i++) {
		drawRow(result[i]);
	}
}

function drawRow(row) {
	var tableRow = $("<tr/>");
	$(".js-books-table-body").append(tableRow);
	tableRow.append("<td>" + row.id + "</td>");
	tableRow.append("<td>" + row.name + "</td>");
	tableRow.append("<td>" + row.publisher + "</td>");
	tableRow.append("<td>" + row.releaseDate + "</td>");
	tableRow.append("<td>" + row.summary + "</td>");
}