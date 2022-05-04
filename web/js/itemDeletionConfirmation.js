$(".Remover").click(function (event) {
  let confirmDeletion = confirm("Certeza que deseja remover esse item?");
  if (!confirmDeletion) {
    event.preventDefault();
  }
});
