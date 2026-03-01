> The primary glTF mod devlopment has been move to CleanroomMC, please see the new [CRglTF](https://github.com/CleanroomMC/CRglTF) repo.

# MCglTF-Example
 Example usages for MCglTF
 
![preview](https://user-images.githubusercontent.com/39574697/177475208-a14f9aa6-5134-4f91-8596-f61c25f09053.png)
## Model Source
https://github.com/KhronosGroup/glTF-Sample-Models/tree/master/2.0#gltf-20-sample-models

- Boom Box and Water Bottle by Microsoft
- Cesium Man by Cesium

In order to adapt into BSL Shaders' SEUS/Old PBR format, some change were made:
- All normal textures had been converted from OpenGL format (Y+) to DirectX format (Y-) by flipping green channel.
- `Occlusion(R)Roughness(G)Metallic(B)` textures and `Emissive color(RGB)` textures had been edited and combined into `Glossiness(R)Metallic(G)Emissive strength(B)` textures for specular map.
## Additonal Note About Setup This Project
1. Before build MCglTF for developmental environment. There is two ways you can choose to avoid gradle compilation error for OptiFine code reference.
	- Simply replace [this line](https://github.com/TimLee9024/MCglTF/blob/0146e9e414312f0e5e2b2dfbe84156c946947844/src/main/java/com/timlee9024/mcgltf/MCglTF.java#L289) with `return false;` in `isShaderModActive()`.
	- Download OptiFine and delete everything except files and folders inside `notch/net/optifine/` of OptiFine JAR. Move all files and folders from `notch/net/optifine/` to `net/optifine/`, which means the `net` folder is now in the root of OptiFine JAR. Then put modified OptiFine JAR into a newly created folder named `libs` in the same dir level as `src` of MCglTF project.
2. Build MCglTF with "gradlew jar" to create a [deobuscated version](https://forums.minecraftforge.net/topic/81617-1152-eclipse-and-gradle-how-to-use-jar-from-another-project-and-import-solved) of MCglTF.
3. Create a folder named `libs` in the same dir level as `src` of MCglTF-Example project.
4. Put deobuscated version of MCglTF into the `libs` folder.
5. In Eclipse IDE, add MCglTF jar as `Referenced Libraries` via `Project > Properties > Java Build Path > Libraries > Add JARs`.
