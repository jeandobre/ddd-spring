Vue.component("ControlBar", {
	template: 
	`<v-app-bar 
		app 
		clipped-right
		flat
		dense
		elevation="1"
		height="68"
		color="#FAFBFC">
		
		<slot></slot>
		
		<v-spacer></v-spacer>	
			
		<slot name="right"></slot>
		    
	</v-app-bar>`
});