Vue.component("ClientsTable", {
	data: () => ({
		search: "",
			
		clients: [{
			name: "Mathias Perez",
			cpf: "075.254.265-99",
			date: "28/01/2022 10:50",
			state: "Em análise"
		}, {
			name: "Jonas Eisenhard",
			cpf: "079.584.540-56",
			date: "27/01/2022 09:10",
			state: "Novo"
		}, {
			name: "Joana da Silva",
			cpf: "185.881.236-54",
			date: "10/01/2022 06:20",
			state: "Novo"
		}],
		
		headers: [{
			value: "name"
		}, {
			value: "date",
			width: "80px"
		}, {
			value: "state",
			align: "center",
			width: "80px"
		}]
	}),
	
	methods: {
		getColor(state) {
			if(state === "Em análise") return "#09B0D6"
			if(state === "Novo") return "#CE9833";
		}
	},
	template: 
	`<v-card height="650">
		<v-card-title>
		Atividades
		<v-spacer></v-spacer>
		<v-text-field
            label="Procurar por..."
            append-icon="mdi-magnify"
            single-line
            hide-details
            v-model="search"
          ></v-text-field>
		</v-card-title>

		 <v-data-table
		    dense
		    :headers="headers"
		    :items="clients"
		    hide-default-header
		    item-key="name"
		    :search="search"
		    class="elevation-1"
		  >
			<template v-slot:item.name="{ item }">
				<div>{{ item.name }}</div>
				{{ item.cpf }}
			</template>
  
			<template v-slot:item.state="{ item }" >
				<v-chip :color="getColor(item.state)" x-small>
					{{ item.state }}
				</v-chip>
			</template>
		</v-data-table>				
	</v-card>`
});