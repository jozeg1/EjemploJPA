<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="Spring" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="Tags" %>

<article>
	<header>
		<H2 class="text-primary">Listado Docentes</H2>
	</header>
	<article>
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>F. Nacimiento</th>
					<th>Celular</th>
					<th>Especialidad</th>
					<th>F. Ingreso</th>

					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="docente" items="${modeloDocentes}">
					<tr>
						<td>${docente.nombre}</td>
						<td>${docente.apellido}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${docente.fechaNacimiento}"/></td>
						<td>${docente.celular}</td>
						<td>${docente.especialidad}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${docente.fechaIngreso}" /></td>

						<td><a href="#">Editar</a></td>
						<td><a href="#">Eliminar</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>

	</article>
	<footer>
		<div class="container">
		<button type="button" id="btn_agregar" class="btn btn-primary" onclick="show_DocenteFormNuevo()">Agregar Docente</button>
		<button type="button" id="btn_cerrar" class="btn btn-secondary" onclick="doCerrarCasoUso()">Cerrar</button>
		</div>
	</footer>
</article>

<script>
	function show_DocenteFormNuevo(){
		$.get("${pageContext.request.contextPath}/docente/nuevo",
	    	function(Resultado){
	    		$('#divCasoForm').html(Resultado);
	    	}
    	)
	}

</script>