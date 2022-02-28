Vue.component("AnaliseCard", {
	
	data: () => ({
		socialId: ""	
	}),
	
	methods: {
		solicitar() {
			
		}
	},
	
	template: 
	`<v-card>
		 <v-card-title>Solicitar análise</v-card-title>
		 <v-card-text>			 
	          <v-text-field 
	          	v-model="socialId"
	          	label="Digite o cpf" 
	          	v-mask="'###.###.###-##'" 
	          	single-line
	          	append-icon="mdi-card-text-outline"
	          	color="teal accent-3">
	          </v-text-field>
			</v-card-title>
		 </v-card-text>
		 <v-card-actions>
		 	<v-spacer></v-spacer>
		 	<v-btn
		        color="teal accent-3"
		        text
		        @click="solicitar"
		      >
		        Solicitar
		      </v-btn>
		 </v-card-actions>			
	</v-card>`
});