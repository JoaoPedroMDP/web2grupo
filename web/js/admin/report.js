function getSelectedReport() {
  return $("#report-selection").attr("data-selected");
}

function setSelectedReport(selectedReport) {
  $("#report-selection").attr("data-selected", selectedReport);
}

$(function () {
  $(".dropdown-item").click(function (event) {
    setSelectedReport(event.target.innerText);
  });

  $(".select-action").click(function (event) {
    var selectedReport = getSelectedReport();
    if (selectedReport == "None") {
      alert("Por favor selecione um relatório");
      return;
    }
    console.log(selectedReport);
  });
});
