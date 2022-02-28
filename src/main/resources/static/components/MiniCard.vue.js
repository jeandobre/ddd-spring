Vue.component("MiniCard", {
	
	props: ["color", "value", "link", "href", "header", "height"],
	
	template: `
		<v-card :color="color" :height="height">
			<div class="ml-2">{{ header }}</div>
			<div class="text-center pa-3">
				<span class="text-h3">{{ value }}</span>
			</div>
			<div class="text-right mr-2">
				<a :href="href">{{ link }}</a>
			</div>	
		</v-card>
	`
});