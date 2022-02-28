Vue.component("RightMenu", {
	template: `<v-navigation-drawer
	      app
	      clipped
	      right
	      width="0"
	    >
	      <v-list>
	        <v-list-item
	          v-for="n in 5"
	          :key="n"
	          link
	        >
	          <v-list-item-content>
	            <v-list-item-title>Item {{ n }}</v-list-item-title>
	          </v-list-item-content>
	        </v-list-item>
	      </v-list>
	    </v-navigation-drawer>`
})