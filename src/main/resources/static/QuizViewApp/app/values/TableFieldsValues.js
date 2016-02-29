angular.module("QuizViewApp").value("tableFieldsValues", {listTableFields:ListTableFields});
function ListTableFields(typeTable){	
	var fields=null;
	switch (true) {
	case typeTable==="tests":
		fields=["idTest","titleTest","createdAt","updatedAt"];
		break;
		
	default:
	}
	return fields;
}