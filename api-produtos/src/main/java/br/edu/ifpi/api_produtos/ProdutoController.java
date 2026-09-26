package br.edu.ifpi.api_produtos;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private int currentId = 1;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtos;
    }

    @GetMapping("/destaque")
    public List<Produto> getProdutosDestaque() {
        return produtos.stream()
                .filter(Produto::isDestaque)
                .toList();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable int id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/{id}/descricao")
    public String getProdutoDescricao(@PathVariable int id) {
        return "Consultando informações do produto " + id;
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        produto.setId(currentId++);
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable int id, @RequestBody Produto updatedProduto) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setNome(updatedProduto.getNome());
                return produto;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }
}