Vue.component("DateTimeCurrent", {
	
	data: () => ({	
		time: ""	
	}),
	
	created() {
		this.getTime();
		setInterval(this.getTime, 1000);
	},
	
	computed: {
		monthNames: () => ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
  "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
  
  		dayOfWeekNames: () => ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "sábado"],
  
		currentDate() {
			const today = new Date();
			const year = today.getFullYear();
			const day = today.getDay();
			const date = today.getDate();
			const month = today.getMonth();
			
			return `${this.dayOfWeekNames[day]}, ${date} de ${this.monthNames[month]} de ${year}`;	
		}
	},
	
	methods: {
		getTime() {
			const today = new Date();				
			this.time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		}
	},
	
	template: 
	`<div>
		<div class="font-weight-light blue-grey--text text--darken-3">{{ time }}</div> 
	 	<div class="font-weight-light blue-grey--text text--darken-3">{{ currentDate }}</div>
	</div>`
	
});